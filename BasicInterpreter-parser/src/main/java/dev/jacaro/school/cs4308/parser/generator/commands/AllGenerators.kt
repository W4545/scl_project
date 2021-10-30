package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.commands.RemarkCommand
import dev.jacaro.school.cs4308.parser.generator.structures.ForLoopGenerator
import dev.jacaro.school.cs4308.parser.generator.structures.IfThenGenerator
import dev.jacaro.school.cs4308.parser.structure.Action
import dev.jacaro.school.cs4308.parser.structure.Generator

val allGenerators = arrayOf<Generator<Action>>(
    CloseCommandGenerator,
    DataCommandGenerator,
    DimCommandGenerator,
    EndCommandGenerator,
    ForLoopGenerator,
    GoToCommandGenerator,
    GoSubCommandGenerator,
    IfThenGenerator,
    InputCommandGenerator,
    LetCommandGenerator,
    NextCommandGenerator,
    OpenCommandGenerator,
    PokeCommandGenerator,
    PrintCommandGenerator,
    ReadCommandGenerator,
    ReturnCommandGenerator,
    RestoreCommandGenerator,
    RunCommandGenerator,
    StopCommandGenerator,
    SysCommandGenerator,
    WaitCommand,
    RemarkCommandGenerator
)