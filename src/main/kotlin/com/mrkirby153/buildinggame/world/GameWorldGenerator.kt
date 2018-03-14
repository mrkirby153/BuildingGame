package com.mrkirby153.buildinggame.world

import org.bukkit.World
import org.bukkit.generator.ChunkGenerator
import java.util.Random

class GameWorldGenerator : ChunkGenerator() {
    override fun generate(world: World?, random: Random?, x: Int, z: Int): ByteArray {
        return ByteArray(32768)
    }
}