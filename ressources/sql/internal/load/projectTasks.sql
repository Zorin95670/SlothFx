SELECT
    "Task"."id",
    "Task"."name"
FROM
    "Task"
LEFT OUTER JOIN "ProjectTasks"
ON  "Task"."id" = "ProjectTasks"."task"
WHERE
    "ProjectTasks"."project" = ?
ORDER BY
    "Task"."name"
