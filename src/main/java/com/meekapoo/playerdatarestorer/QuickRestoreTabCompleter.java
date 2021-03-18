package com.meekapoo.playerdatarestorer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class QuickRestoreTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        //pd restore [player] quick
        if (sender.isOp()) {
            if (command.getName().equals("pd")) {
                ArrayList<String> list = new ArrayList<>();
                if (args.length == 1) {
                    list.add("restore");
                    return list;
                } else if (args.length == 2 && args[0].equals("restore")) {
                    UUIDManager.players.keySet().forEach((key) -> list.add(key));
                    return list;
                } else if (args.length == 3) {
                    list.add("quick");
                    return list;
                } else return list;
            }
            return null;
        } else return new ArrayList<String>();
    }
}
