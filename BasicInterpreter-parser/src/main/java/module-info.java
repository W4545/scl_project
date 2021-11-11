module dev.jacaro.basicinterpreter.parser {
    requires dev.jacaro.basicinterpreter.core;
    requires dev.jacaro.basicinterpreter.scanner;

    requires kotlin.stdlib;

    exports dev.jacaro.school.cs4308.parser;
    exports dev.jacaro.school.cs4308.parser.structure;
    exports dev.jacaro.school.cs4308.parser.generator;

}