package org.zaksen.fhapi.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.zaksen.fhapi.text.HologramManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HologramCMDTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
        Player player = null;
        if((commandSender instanceof Player)) {
            player = (Player) commandSender;
        }
        String subcommand = args[0];
        switch (args.length) {
            case 1: {
                return Arrays.asList("spawn", "remove", "modify");
            }
            case 2: {
                switch (subcommand) {
                    case "spawn": {
                        return Collections.singletonList("text");
                    }
                    case "remove":
                    case "modify": {
                        return HologramManager.getIds();
                    }
                }
            }
            case 3: {
                switch (subcommand) {
                    case "spawn": {
                        return Arrays.asList("id", "last");
                    }
                    case "modify": {
                        return Arrays.asList("scale", "alignment", "billboard", "line_width", "position", "glow_color",
                                "see_through", "text_opacity", "shadow", "background", "text", "view_range", "translation",
                                "left_rotation", "right_rotation", "rotation");
                    }
                }
            }
            case 4: {
                if (subcommand.equals("modify")) {
                    String modifySubcommand = args[2];
                    switch (modifySubcommand) {
                        case "scale":
                        case "view_range":
                        case "translation":
                        case "left_rotation":
                        case "right_rotation": {
                            return Collections.singletonList("1.0");
                        }
                        case "alignment": {
                            return Arrays.asList("left", "center", "right");
                        }
                        case "billboard": {
                            return Arrays.asList("fixed", "vertical", "horizontal", "center");
                        }
                        case "line_width": {
                            return Collections.singletonList("200");
                        }
                        case "position": {
                            return Collections.singletonList(String.valueOf(player.getLocation().getBlockX()));
                        }
                        case "glow_color":
                        case "background": {
                            return Arrays.asList("red", "255");
                        }
                        case "see_through":
                        case "shadow": {
                            return Arrays.asList("true", "false");
                        }
                        case "text_opacity": {
                            return Arrays.asList("-1", "127");
                        }
                        case "text": {
                            return Collections.singletonList("text");
                        }
                        case "rotation": {
                            return Arrays.asList("-180", "0", "180");
                        }
                    }
                }
            }
            case 5: {
                if (subcommand.equals("modify")) {
                    String modifySubcommand = args[2];
                    switch (modifySubcommand) {
                        case "scale":
                        case "translation":
                        case "left_rotation":
                        case "right_rotation": {
                            return Collections.singletonList("1.0");
                        }
                        case "position": {
                            return Collections.singletonList(String.valueOf(player.getLocation().getBlockY()));
                        }
                        case "glow_color":
                        case "background": {
                            return Arrays.asList("green", "255");
                        }
                        case "rotation": {
                            return Arrays.asList("-90", "0", "90");
                        }
                    }
                }
            }
            case 6: {
                if (subcommand.equals("modify")) {
                    String modifySubcommand = args[2];
                    switch (modifySubcommand) {
                        case "scale":
                        case "translation":
                        case "left_rotation":
                        case "right_rotation": {
                            return Collections.singletonList("1.0");
                        }
                        case "position": {
                            return Collections.singletonList(String.valueOf(player.getLocation().getBlockZ()));
                        }
                        case "glow_color":
                        case "background": {
                            return Arrays.asList("blue", "255");
                        }
                    }
                }
            }
            case 7: {
                if(subcommand.equals("modify")) {
                    String modifySubcommand = args[2];
                    switch (modifySubcommand) {
                        case "left_rotation":
                        case "right_rotation": {
                            return Collections.singletonList("1.0");
                        }
                        case "background": {
                            return Arrays.asList("alpha", "255");
                        }
                    }
                }
            }
            default: {
                return Collections.singletonList("");
            }
        }
    }
}
