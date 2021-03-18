package com.meekapoo.playerdatarestorer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class QuickRestore implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.isOp()) {
            if(args.length == 0) sender.sendMessage("Too few arguments! Usage: /pd restore [player] quick");
            if(args.length == 1) {
                if(args[0] == "list") {
                    UUIDManager.players.forEach((player,id) -> {
                        sender.sendMessage(player + ", " + id);
                    });
                } else {
                    sender.sendMessage("Too few arguments! Usage: /pd restore [player] quick");
                }
            }
            if (!args[0].toLowerCase().equals("restore")) {
                sender.sendMessage("Unknown Command! You must feel more lost then when I went hiking in the Mystery Dog-Kicker Forest... Please use \"/pd restore [player] [type (just put 'quick' here lol)]\"");
                return false;
            }
            int code = UUIDManager.quickRestore(args[1]);
            if (code == UUIDManager.ERR_PLAYER_NOT_KNOWN) {
                sender.sendMessage("Bruuuuhhhh idk who " + args[1] + " is tho.. Check spelling and ask Micah to check the UUID database");
                return false;
            } else if (code == UUIDManager.ERR_ALREADY_RESTORED) {
                sender.sendMessage(args[1] + " has already gotten their data restored/old quicksaved playerdata is gone");
                return false;
            } else if (code == UUIDManager.ERR_CANT_RENAME) {
                sender.sendMessage("file manager error -- " + UUIDManager.players.get(args[1]) + ".dat");
            } else if (code == UUIDManager.NO_ERR) {
                sender.sendMessage("Woohoo!! You did it! " + args[1] + "'s playerdata has been restored to the last autosave");
                return true;
            } else return false;
        } else {
            sender.sendMessage("You are not an OP!");
            return false;
        }
        return false;
    }
}


