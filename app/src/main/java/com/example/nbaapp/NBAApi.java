package com.example.nbaapp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class NBAApi {
    ArrayList<NBA>GetNBA(){
        String BASE_URL="https://liowjvzcwviiusliopya.supabase.co/rest/v1/NBA?apikey=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imxpb3dqdnpjd3ZpaXVzbGlvcHlhIiwicm9sZSI6ImFub24iLCJpYXQiOjE2Njc0MTM2MjEsImV4cCI6MTk4Mjk4OTYyMX0.2cqEAkbqS0i6POYpUXgYVfj4r035BoJxbjN2CKkvARk";

        try{
           String result = HttpUtils.get(BASE_URL);

            JSONArray results = new JSONArray(result);
            ArrayList<NBA>nbas=new ArrayList<>();

            for (int i=0;i<results.length();i++){

                JSONObject nbaJson = results.getJSONObject(i);
                NBA nba = new NBA();
                nba.setId(nbaJson.getString("id"));
                nba.setCiudad(nbaJson.getString("ciudad"));
                nba.setEquipo(nbaJson.getString("equipo"));
                nba.setAnyof(nbaJson.getInt("anyof"));
                nba.setPabellon(nbaJson.getString("pabellon"));
                nba.setImagenurl(nbaJson.getString("imagenurl"));
                nba.setPalmares(nbaJson.getString("palmares"));

                nbas.add(nba);
            }


            return nbas;
        }

catch (Exception e){
            System.err.println(e.getMessage());
}
return null;
    }
}
