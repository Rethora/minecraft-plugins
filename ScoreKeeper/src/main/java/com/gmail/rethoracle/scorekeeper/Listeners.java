package com.gmail.rethoracle.scorekeeper;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import java.io.*;

public class Listeners implements Listener {

    private final File playerStorage;

    public Listeners(File playerStorageFile) {
        playerStorage = playerStorageFile;
    }

    @EventHandler
    public void onPlayerKilled(PlayerDeathEvent event) {
        Player deadPlayer = event.getEntity().getPlayer();
        assert deadPlayer != null;
        Player playerKiller = deadPlayer.getKiller();
        if (playerKiller != null) {
            JSONParser parser = new JSONParser();
            try {
                // TODO: add key value pair if not exist
                Object obj = parser.parse(new FileReader(playerStorage.getName()));
                JSONObject jo = (JSONObject) obj;

                JSONObject deadPlayerObj = (JSONObject) jo.get(deadPlayer.getDisplayName());
                JSONObject deadPlayerDeathsObj = (JSONObject) deadPlayerObj.get("deaths");
                int deadPlayerDeaths = (int) deadPlayerDeathsObj.get(playerKiller.getDisplayName());

                JSONObject playerKillerObj = (JSONObject) jo.get(playerKiller.getDisplayName());
                JSONObject playerKillerDeathsObj = (JSONObject) playerKillerObj.get("deaths");
                int playerKillerDeaths = (int) playerKillerDeathsObj.get(deadPlayer.getDisplayName());

//                JSONValue value = (JSONValue) jo.get(deadPlayer.getDisplayName());
//                JSONArray companyList = (JSONArray) jo.get("Company List");
//                JSON

                // An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
                // Iterators differ from enumerations in two ways:
                // 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
                // 2. Method names have been improved.
//                Iterator<JSONObject> iterator = companyList.iterator();
//                while (iterator.hasNext()) {
//                    System.out.println(iterator.next());
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
