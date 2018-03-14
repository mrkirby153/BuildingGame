package com.mrkirby153.buildinggame.command

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.Subcommand
import com.mrkirby153.buildinggame.BuildingGame
import com.mrkirby153.buildinggame.game.Arena
import me.mrkirby153.kcutils.Chat
import org.bukkit.command.CommandSender

@CommandAlias("arena")
class ArenaCommand(val plugin: BuildingGame) : BaseCommand() {

    @Subcommand("create")
    fun create(sender: CommandSender) {
        if (plugin.arena == null)
            plugin.arena = Arena(plugin)
        plugin.arena!!.createWorld()
        sender.sendMessage(Chat.message("World created!").toLegacyText())
    }

    @Subcommand("destroy")
    fun destroy(sender: CommandSender) {
        if (plugin.arena != null) {
            plugin.arena?.destroyWorld()
            sender.sendMessage(Chat.message("World destroyed!").toLegacyText())
        } else {
            sender.sendMessage(Chat.error("The world has not been created!").toLegacyText())
        }
    }
}