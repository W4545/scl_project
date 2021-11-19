package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.generator.structures.ForLoopGenerator
import dev.jacaro.school.cs4308.parser.generator.structures.IfThenGenerator
import dev.jacaro.school.cs4308.structure.Action
import dev.jacaro.school.cs4308.parser.structure.Generator

val allGenerators = arrayOf(
    DataCommandGenerator,
    EndCommandGenerator,
    ForLoopGenerator,
    GoToCommandGenerator,
    GoSubCommandGenerator,
    IfThenGenerator,
    LetCommandGenerator,
    NextCommandGenerator,
    PrintCommandGenerator,
    ReadCommandGenerator,
    ReturnCommandGenerator,
    StopCommandGenerator,
    RemarkCommandGenerator
)