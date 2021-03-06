CREATE TABLE IF NOT EXISTS "TaskTimes"(
    "id"   INTEGER PRIMARY KEY AUTOINCREMENT,
    "task" INTEGER NOT NULL,
    "time" INTEGER NOT NULL,
    FOREIGN KEY("task") REFERENCES "Task"("id"),
    FOREIGN KEY("time") REFERENCES "Time"("id")
);

