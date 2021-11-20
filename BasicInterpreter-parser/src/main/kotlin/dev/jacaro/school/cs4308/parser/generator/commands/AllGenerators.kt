package dev.jacaro.school.cs4308.parser.generator.commands

import dev.jacaro.school.cs4308.parser.generator.structures.ForLoopGenerator
import dev.jacaro.school.cs4308.parser.generator.structures.IfThenGenerator

/**
 * Holds all active command generators.
 */
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