/*
 * Pore
 * Copyright (c) 2014-2015, Lapis <https://github.com/LapisBlue>
 *
 * The MIT License
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
package blue.lapis.pore.command;

import blue.lapis.pore.impl.command.PoreCommandSender;
import blue.lapis.pore.util.PoreWrapper;

import com.google.common.base.Optional;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.command.Command;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.util.annotation.NonnullByDefault;
import org.spongepowered.api.util.command.CommandCallable;
import org.spongepowered.api.util.command.CommandException;
import org.spongepowered.api.util.command.CommandResult;
import org.spongepowered.api.util.command.CommandSource;

import java.util.List;

@NonnullByDefault
public class PoreCommandCallable extends PoreWrapper<Command> implements CommandCallable {

    public PoreCommandCallable(Command handle) {
        super(handle);
    }

    @Override
    public Optional<CommandResult> process(CommandSource source, String arguments) throws CommandException {
        // TODO: Label
        if (getHandle().execute(PoreCommandSender.of(source), getHandle().getLabel(),
                StringUtils.split(arguments))) {
            return Optional.of(CommandResult.success());
        } else {
            return Optional.of(CommandResult.empty());
        }
    }

    @Override
    public List<String> getSuggestions(CommandSource source, String arguments) throws CommandException {
        // TODO: Label
        return getHandle().tabComplete(PoreCommandSender.of(source), getHandle().getLabel(),
                StringUtils.split(arguments));
    }

    @Override
    public boolean testPermission(CommandSource source) {
        return getHandle().testPermissionSilent(PoreCommandSender.of(source));
    }

    @Override
    public Optional<? extends Text> getShortDescription(CommandSource source) {
        return getHelp(source);
    }

    @Override
    public Optional<? extends Text> getHelp(CommandSource source) {
        return Optional.of(Texts.fromLegacy(getHandle().getDescription()));
    }

    @Override
    public Text getUsage(CommandSource source) {
        return Texts.fromLegacy(getHandle().getUsage());
    }

}
