package wraith.necessities.command;

import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;

public class CommandRegistry {

    public static void registerAllCommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {

            dispatcher.register(CommandManager.literal("stack")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(context -> {
                    ServerPlayerEntity player = context.getSource().getPlayer();
                    if (player != null) {
                        CommandFunctions.stackItem(player);
                    }
                    return 1;
                })
                .then(CommandManager.argument("player", EntityArgumentType.players())
                    .executes(context -> {
                        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
                        if (player != null) {
                            CommandFunctions.stackItem(player);
                        }
                        return 1;
                    }))
            );

            dispatcher.register(CommandManager.literal("repair")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(context -> {
                    ServerPlayerEntity player = context.getSource().getPlayer();
                    if (player != null) {
                        CommandFunctions.repairItem(player, -1);
                    }
                    return 1;
                })
                .then(CommandManager.argument("player", EntityArgumentType.players())
                    .executes(context -> {
                        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
                        if (player != null) {
                            CommandFunctions.repairItem(player, -1);
                        }
                        return 1;
                    })
                    .then(CommandManager.argument("amount", IntegerArgumentType.integer(0))
                        .executes(context -> {
                            ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
                            if (player != null) {
                                CommandFunctions.repairItem(player, IntegerArgumentType.getInteger(context, "amount"));
                            }
                            return 1;
                        })
                    )
                )
                .then(CommandManager.argument("amount", IntegerArgumentType.integer(0))
                    .executes(context -> {
                        ServerPlayerEntity player = context.getSource().getPlayer();
                        if (player != null) {
                            CommandFunctions.repairItem(player, IntegerArgumentType.getInteger(context, "amount"));
                        }
                        return 1;
                    })
                )
            );

            dispatcher.register(CommandManager.literal("fix")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(context -> {
                    ServerPlayerEntity player = context.getSource().getPlayer();
                    if (player != null) {
                        CommandFunctions.repairItem(player, -1);
                    }
                    return 1;
                })
                .then(CommandManager.argument("player", EntityArgumentType.players())
                    .executes(context -> {
                        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
                        if (player != null) {
                            CommandFunctions.repairItem(player, -1);
                        }
                        return 1;
                    })
                    .then(CommandManager.argument("amount", IntegerArgumentType.integer(0))
                        .executes(context -> {
                            ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
                            if (player != null) {
                                CommandFunctions.repairItem(player, IntegerArgumentType.getInteger(context, "amount"));
                            }
                            return 1;
                        })
                    )
                )
                .then(CommandManager.argument("amount", IntegerArgumentType.integer(0))
                    .executes(context -> {
                        ServerPlayerEntity player = context.getSource().getPlayer();
                        if (player != null) {
                            CommandFunctions.repairItem(player, IntegerArgumentType.getInteger(context, "amount"));
                        }
                        return 1;
                    })
                )
            );

            dispatcher.register(CommandManager.literal("damage")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(context -> {
                    ServerPlayerEntity player = context.getSource().getPlayer();
                    if (player != null) {
                        CommandFunctions.damageItem(player, 1);
                    }
                    return 1;
                })
                .then(CommandManager.argument("player", EntityArgumentType.players())
                    .executes(context -> {
                        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
                        if (player != null) {
                            CommandFunctions.damageItem(player, 1);
                        }
                        return 1;
                    })
                    .then(CommandManager.argument("amount", IntegerArgumentType.integer(0))
                        .executes(context -> {
                            ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
                            if (player != null) {
                                CommandFunctions.damageItem(player, IntegerArgumentType.getInteger(context, "amount"));
                            }
                            return 1;
                        })
                    )
                )
                .then(CommandManager.argument("amount", IntegerArgumentType.integer(0))
                    .executes(context -> {
                        ServerPlayerEntity player = context.getSource().getPlayer();
                        if (player != null) {
                            CommandFunctions.damageItem(player, IntegerArgumentType.getInteger(context, "amount"));
                        }
                        return 1;
                    })
                )
            );

        dispatcher.register(CommandManager.literal("heal")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(context -> {
                    ServerPlayerEntity player = context.getSource().getPlayer();
                    if (player != null) {
                        CommandFunctions.healPlayer(player, -1f);
                    }
                    return 1;
                })
                .then(CommandManager.argument("player", EntityArgumentType.players())
                    .executes(context -> {
                        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
                        if (player != null) {
                            CommandFunctions.healPlayer(player, -1f);
                        }
                        return 1;
                    })
                    .then(CommandManager.argument("amount", FloatArgumentType.floatArg(0))
                        .executes(context -> {
                            ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
                            if (player != null) {
                                CommandFunctions.healPlayer(player, FloatArgumentType.getFloat(context, "amount"));
                            }
                            return 1;
                        })
                    )
                )
                .then(CommandManager.argument("amount", FloatArgumentType.floatArg(0))
                    .executes(context -> {
                        ServerPlayerEntity player = context.getSource().getPlayer();
                        if (player != null) {
                            CommandFunctions.healPlayer(player, FloatArgumentType.getFloat(context, "amount"));
                        }
                        return 1;
                    })
                )
            );

            dispatcher.register(CommandManager.literal("hurt")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(context -> {
                    ServerPlayerEntity player = context.getSource().getPlayer();
                    if (player != null) {
                        CommandFunctions.hurtPlayer(player, 1f);
                    }
                    return 1;
                })
                .then(CommandManager.argument("player", EntityArgumentType.players())
                    .executes(context -> {
                        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
                        if (player != null) {
                            CommandFunctions.hurtPlayer(player, 1f);
                        }
                        return 1;
                    })
                    .then(CommandManager.argument("amount", FloatArgumentType.floatArg(0))
                        .executes(context -> {
                            ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
                            if (player != null) {
                                CommandFunctions.hurtPlayer(player, FloatArgumentType.getFloat(context, "amount"));
                            }
                            return 1;
                        })
                    )
                )
                .then(CommandManager.argument("amount", FloatArgumentType.floatArg(0))
                    .executes(context -> {
                        ServerPlayerEntity player = context.getSource().getPlayer();
                        if (player != null) {
                            CommandFunctions.hurtPlayer(player, FloatArgumentType.getFloat(context, "amount"));
                        }
                        return 1;
                    })
                )
            );
            
            dispatcher.register(CommandManager.literal("disenchant")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(context -> {
                    ServerPlayerEntity player = context.getSource().getPlayer();
                    if (player != null) {
                        CommandFunctions.disenchant(player);
                    }
                    return 1;
                })
                .then(CommandManager.argument("player", EntityArgumentType.players())
                    .executes(context -> {
                        ServerPlayerEntity player = EntityArgumentType.getPlayer(context, "player");
                        if (player != null) {
                            CommandFunctions.disenchant(player);
                        }
                        return 1;
                    })
                )
            );


        });
    }

}
