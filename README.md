# Synoptic Extensions Project 
This repository contains the code of the following projects:
1. Log differnecing: 2kdiff, nkdiff
2. kTails: many parameters
3. Dynamic kTails

## Installation
The proejcts have been developed over the Eclipse framework, therefore a working installation of Eclipse (preferably version above or equals 2019-03) is a prerequisite.

In order to compile Spectra synthesizer from source code:
- `git clone` this repository into your computer, along with `spectra-lang`.
- Import all existing projects from both repositories into an Eclipse workspace.
- Build Spectra language auto generated code by right clicking on `src/tau.smlab.syntech.GenerateSpectra.mwe2` and then 'Run As -> MWE2 Workflow`.
- Run project by creating a new `Eclipse Application` configuration in `Run Configurations` window.
- On Linux additionally run `sudo apt install openjdk-8-jdk openjfx`.

## Licensing
Synoptic Extensions Project is licensed under BSD-3-Clause. It uses CUDD library, which is also licensed under BSD-3-Clause, and whose modified code can be found in this repository. 
It also uses Brics automaton library, licensed under BSD-2-Clause and available here: https://www.brics.dk/automaton/. It also uses code from synoptic: https://github.com/ModelInference/synoptic/ under The MIT License (MIT).
