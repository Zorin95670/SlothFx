SELECT
    "Tag"."id",
    "Tag"."name"
FROM
    "Tag"
LEFT OUTER JOIN "TaskTags"
ON  "Tag"."id" = "TaskTags"."tag"
WHERE
    "TaskTags"."task" = ?
ORDER BY
    "Tag"."name"
