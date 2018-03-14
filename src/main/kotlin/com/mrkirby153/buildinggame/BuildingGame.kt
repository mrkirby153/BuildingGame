package com.mrkirby153.buildinggame

import co.aikar.commands.BukkitCommandManager
import com.mrkirby153.buildinggame.command.ArenaCommand
import com.mrkirby153.buildinggame.game.Arena
import org.bukkit.plugin.java.JavaPlugin

class BuildingGame : JavaPlugin() {

    var arena: Arena? = null

    lateinit var commandManager: BukkitCommandManager

    override fun onEnable() {
        commandManager = BukkitCommandManager(this)
        registerCommands()
    }

    /**
     * Register commands with ACF
     */
    private fun registerCommands() {
        commandManager.registerCommand(ArenaCommand(this))
    }
}