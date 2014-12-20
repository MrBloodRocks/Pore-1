/*
 * Pore
 * Copyright (c) 2014, Lapis <https://github.com/LapisBlue>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.amigocraft.pore.util.converter;

import net.amigocraft.pore.Pore;
import org.spongepowered.api.potion.PotionEffectBuilder;

public class PotionEffectConverter {

    private static PotionEffectBuilder effectBuilder = Pore.getGame().getRegistry().getPotionEffectBuilder();

    public static org.spongepowered.api.potion.PotionEffect of(org.bukkit.potion.PotionEffect effect) {
        return effectBuilder
                .potionType(PotionEffectTypeConverter.of(effect.getType()))
                .ambience(effect.isAmbient())
                .amplifier(effect.getAmplifier())
                .duration(effect.getDuration())
                .particles(effect.hasParticles())
                .build();
    }

    public static org.bukkit.potion.PotionEffect of(org.spongepowered.api.potion.PotionEffect effect) {
        return new org.bukkit.potion.PotionEffect(
                PotionEffectTypeConverter.of(effect.getType()),
                effect.getDuration(),
                effect.getAmplifier(),
                effect.isAmbient(),
                effect.getShowParticles()
        );
    }

}
