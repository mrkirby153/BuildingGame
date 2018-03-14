package com.mrkirby153.buildinggame.game

import com.mrkirby153.buildinggame.BuildingGame
import com.mrkirby153.buildinggame.world.GameWorldGenerator
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.WorldCreator
import org.bukkit.entity.Player
import java.io.File
import java.util.UUID

class Arena(val plugin: BuildingGame) {

    val worldCreator: WorldCreator = WorldCreator(
            "buildinggame_${UUID.randomUUID().toString().replace("-", "").substring(0, 5)}")
    var world: World? = null

    val players = mutableListOf<UUID>()

    var spawn: Location? = null

    init {
        worldCreator.generator(GameWorldGenerator())
    }

    /**
     * Adds the player to the arena
     *
     * @param player The player to join
     */
    fun join(player: Player) {
        players.add(player.uniqueId)
        player.teleport(spawn ?: world?.spawnLocation ?: throw IllegalStateException(
                "World has not been created!"))
    }

    /**
     * Creates the world
     */
    fun createWorld() {
        this.world = worldCreator.createWorld()
    }

    /**
     * Destroys the world
     */
    fun destroyWorld() {
        if (world != null)
            Bukkit.unloadWorld(world, true)
        plugin.server.scheduler.runTaskLater(plugin, {
            File(Bukkit.getWorldContainer(), worldCreator.name()).deleteRecursively()
        }, 120)
        world = null
    }
}