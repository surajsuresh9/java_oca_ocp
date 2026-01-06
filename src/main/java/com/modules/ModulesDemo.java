package com.modules;

public class ModulesDemo {
    /*
            Modules
            Java Platform Module System (JPMS)
                - in practice, we often need to use libraries (code) written by others
                - one way to use these libraries is to use jar files
                    - the right compatible version needs to be ensured all the time
                    - this creates complex chain of dependencies and minimum versions
                - another way is to use modules
                    - they provide groups of related packages with some set of functionalities
                    - developer chooses which packages are accessible outside the module

            Benefits of Modules
                - better access control
                    - you can hav e packages which are only accessible to other packages
                - clearer dependency manager
                    - if dependency is missing, Jav will complain when starting the program
                - custom Java builds
                    - you can choose which parts of the JDK you need
                - improved security
                    - you only have to worry about modules that you use
                - improved performance
                    - comes with smaller Java package

              module-info.java
                - a module os a group of one or more packages plus module-info.java file
                - contents of this file is called module declaration
                - module declaration defines dependencies
                    - the way one module relies on code in another one
                    - these are defined using module declaration keyword

              module-info.java: keywords

              Keyword                                                   Description
              -----------------------------------------------------------------------------------------------------------
              requires <modules>                                        Module depends on the code in another module
              requires transitive  <modules>                            If module A "requires transitive" module B, and module C "requires" module A, then C will have access to B
              opens <package> to <module>                               Makes named package accessible to the named module in the runtime
              exports <package>                                         Public members of the name package are accessible to other modules
              uses <service>                                            The module uses a service(i.e interface) which can be implemented elsewhere
              provides <service> with <implementation>                  The module provides a concrete implementation of a service(i.e interface) (SPI - service provider interface)


            Compiling and Running Modules

                - Compiling with javac
                     Directory for class files  -d <dir>               n/a
                     Directory for class files  -p <path>              --module-path <path>

                - Running the program with java

                    Module name                 -m <name>           --module <name>
                    Module path                 -p <path>           --module-path <path>

                - exports is important as it allows to export a module, and then allows other modules to import it (class and interfaces have to export)

                - requires defines availability in compile time
                - opens defines availability in runtime


                - uses : used to denote an SPI (service provider interface) ; (e.g: uses fully_qualified_interface_name)
                - provides <fully_qualified_interface_name> with <fully_qualified_interface_implementation> (no need to export as interface already exports)

              - Built-in modules
                - java.base (available to all modular apps)
                - java.sql
                - java.desktop
                - java.logging
                - java.xml

              - Java modules prefixed with 'jdk'
                - jdk.accessibility
                - jdk.charset
                - jdk.attach
                - jdk.jcmd
                - jdk.jartool
                - many more

              - Command Line Operations

                // compile non-modular code
                javac -cp <classpath> -d <directory> <classesToCompile>
                    or
                javac --classpath <classpath> -d <directory> <classesToCompile>
                    or
                javac --class-path <classpath> -d <directory> <classesToCompile>


                // run non-modular code
                java -cp <classpath>  <package>.<className>
                    or
                java --classpath <classpath>  <package>.<className>
                    or
                java --class-path <classpath>  <package>.<className>


                // compile module
                javac -p <moduleFolderName> -d <directory> <classesToCompilePlusModuleInfo>
                    or
                javac --module-path <moduleFolderName> -d <directory> <classesToCompilePlusModuleInfo>


                // run module
                java -p <moduleFolderName>  <moduleName/package.className>
                java --module-path <moduleFolderName>  <moduleName/package.className>


                // describe module (which pkg this module exports and which other modules are required by this module)
                java -p <moduleFolderName> -d <moduleName>
                java -module-path <moduleFolderName> --describe-module <moduleName>
                jar --file <jarName> --describe-module
                jar -f <jarName> -d


                // list all available modules
                java --module-path <moduleFolderName> --list-modules
                java -p <moduleFolderName> --list-modules
                java --list-modules (already in module folder)

                // views dependencies
                jdeps -summary --module-path <moduleFolderName> <jarName>
                jdeps -s --module-path <moduleFolderName> <jarName>
                jdeps --jdk-internals <jarName>
                jdeps -jdkinternals <jarName>

                // show module resolution
                java --show-module-resolution --module-path <moduleFolderName> --module <moduleName>
                java --show-module-resolution -p <moduleFolderName> -m <moduleName>

                // create runtime JAR
                jlink --module-path <moduleFolderName> --add-modules <moduleName> --output <directory>
                jlink -p <moduleFolderName> --add-modules <moduleName> --output <directory>

                Using jmod
                 - JMOD files are used when you have libraries that can't go inside a JAR file
                 - need to know common modes used by jmod
                    - create - creates JMOD file
                    - extracts - extracts all JMOD files (like unzipping)
                    - describe - prints module details (such as requires)
                    - list - lists all files in JMOD file
                    - hash - prints or records hashes

                 Named, Automatic and Unnamed modules

                    - Named Module
                        - contains module-info.java file
                            - this file in the root of the JAR alongside other package(s)
                        - module name is specified in module-info.java
                        - named modules appear in the module path (not the classpath!)

                    - Automatic Module
                        - appear on the module path
                        - it doesn't contain module-info.java
                        - basically the regular JAR file placed in the module path and treated as a module
                        - in the case Java automatically determines the module name
                        - unless there is a file called MANIFEST.MF in META-INF folder in .jar file
                            - in this file one can set the property Automatic-Module-Name
                            - this is from the 'old days', helping devs transform jars to modules
                            - in this case, the name of the module is read from property

                    - Algorithm for naming automatic module
                        - remove the file extension from teh JAR file name
                        - remove any version information from the end of the name
                        - replace any remaining chars other than letters and numbers with dots
                        - replace any sequences of dots with a single dot
                        - remove the dot if it is the first ot last char of the result

                            mod_$-1.0-RC.jar ---> mod_$_1.0-RC ---> mod_$ ---> mod.. ---> mod. ---> mod

                    - Unnamed Modules
                        - appears on the classpath (unlike automatic modules)
                        - basically a regular JAR in the classpath
                        - usually doesn't contain module-info.java (if it does, it's ignored)
                        - unnamed modules don't export any packages to named or automatic modules
                            - it can only read from any JARs on the classpath or module path
                        - important
                            - code on the classpath can access the module path
                            - code on the module path is unable to read from the classpath

                    - Migrating the Application
                        - many apps were written before JPMS was introduced
                        -  with migration, you can migrate the existing apps to use modules
                        - there are 2 approaches to migrate
                            - bottom-up approach
                                - used when you have control over JAR files on which your app depends
                            - top-down approach
                                - useful when you don;t have control over any JAR file used in your app

                       - Bottom-Up Migration Strategy
                         - pick the lowest-level project that has not yet been migrated
                         - add module-info.java to that project with appropriate exports/ requires
                         - move newly migrated named modules from the class to module path
                         - do this until there are no more unnamed modules on the classpath
                         - repeat with the next lowest-level project until you're done

                       - Top-Down Migration Strategy
                         - place all projects on the module path
                         - pick teh highest-level project that has not yet been migrated
                         - add module-info.java to the project
                            - this converts automatic module into a named module
                            - add appropriate exports/ required statements
                            - you can use the automatic module name of other modules in the process
                         - repeat with the next highest-level project until you're done

     */
}
