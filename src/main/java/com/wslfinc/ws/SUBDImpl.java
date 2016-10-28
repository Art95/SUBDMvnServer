package com.wslfinc.ws;

/**
 * Created by Artem on 15.10.2016.
 */

import com.wslfinc.database.DataBase;

import javax.jws.WebService;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@WebService(serviceName = "DatabaseService", endpointInterface = "com.wslfinc.ws.SUBDInterface")
public class SUBDImpl implements SUBDInterface {
    private Map<String, DataBase> dataBaseMap;
    //private final String folderAddress = "./Databases/";

    public SUBDImpl() {
        super();
    }

    @Override
    public void createDataBase(String name) {
        if (dataBaseMap == null)
            loadDataBases();

        if (dataBaseMap.containsKey(name)) {
            System.out.println("Data base " + name + " already exists!");
            return;
        }

        DataBase db = new DataBase(name);
        dataBaseMap.put(name, db);
    }

    @Override
    public void dropDataBase(String name) {
        if (dataBaseMap == null)
            loadDataBases();

        if (dataBaseMap.containsKey(name)) {
            dataBaseMap.remove(name);

            //File file = new File(folderAddress + name + ".txt");
            //file.delete();
        }
    }

    @Override
    public void saveDataBase(String name, String data) {
        if (dataBaseMap == null)
            loadDataBases();

        try {
            if (dataBaseMap.containsKey(name)) {

                dataBaseMap.put(name, DataBase.parseJson(data));
                //dataBaseMap.get(name).saveDataBase(folderAddress + name + ".txt");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getDataBaseData(String name) {
        if (dataBaseMap == null)
            loadDataBases();

        if (dataBaseMap.containsKey(name))
            return dataBaseMap.get(name).toJson();

        return null;
    }

    @Override
    public String[] getDataBasesNames() {
        if (dataBaseMap == null)
            loadDataBases();

        Object[] names = dataBaseMap.keySet().toArray();

        String[] res = new String[names.length];

        for (int i = 0; i < names.length; ++i)
            res[i] = names[i].toString();

        return res;
    }

    private void loadDataBases() {
        dataBaseMap = new HashMap<>();

        /*File dir = new File(folderAddress);
        File[] files = dir.listFiles();

        for (File file : files) {
            try {
                DataBase db = DataBase.loadDataBase(file.getAbsolutePath());
                dataBaseMap.put(db.getName(), db);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }*/
    }
}
