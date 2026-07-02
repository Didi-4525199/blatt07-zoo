Aufgabe 3 Reflexion

Generics

Wo helfen Generics im Zoo-Szenario, Fehler bereits zur Compile-Zeit zu vermeiden?

Generics sorgen dafür, dass nur passende Tiere in ein Gehege eingefügt werden können. Dadurch werden Fehler bereits beim Kompilieren erkannt.

Beispiel:

Ein Aquarium kann nur Fische aufnehmen. Ein Shark oder Goldfish ist erlaubt. Ein Monkey oder Leopard kann nicht hinzugefügt werden. Der Compiler verhindert diese falschen Tier-Gehege-Kombinationen.

Logging

Warum ist Logging besser als System.out.println()?

Ein Logger bietet verschiedene Log-Level und ermöglicht es, Meldungen gezielt auszugeben. Dadurch lassen sich Programmabläufe und Fehler leichter nachvollziehen als mit einfachen Konsolenausgaben.

Verwendung der Log-Level:

INFO: Normale Aktionen, z. B. Gehege hinzufügen oder Tiere abrufen.

WARNING: Wenn ein Tier oder Gehege nicht gefunden wird.

SEVERE: Bei schwerwiegenden Fehlern oder inkonsistenten Zuständen im Zoo.

Streams

Wo haben Streams geholfen?

Streams haben das Filtern, Sammeln und Zählen von Tieren vereinfacht. Sie wurden beispielsweise in den Methoden getAllAnimals(), getAllMammals() und countAnimalsByType() verwendet.

Wo wurden Streams eher unübersichtlich?

Bei längeren Stream-Ketten kann die Lesbarkeit schlechter werden. Für einfache oder sehr komplexe Abläufe können klassische for-Schleifen manchmal übersichtlicher sein.
