CREATE TABLE IF NOT EXISTS "ProjectTags"(
    "id"      INTEGER PRIMARY KEY AUTOINCREMENT,
    "project" INTEGER NOT NULL,
    "tag"     INTEGER NOT NULL,
    FOREIGN KEY("project") REFERENCES "Project"("id"),
    FOREIGN KEY("tag")     REFERENCES "Tag"("id")
);

