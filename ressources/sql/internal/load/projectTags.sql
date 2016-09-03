SELECT
    "Tag"."id",
    "Tag"."name"
FROM
    "Tag"
LEFT OUTER JOIN "ProjectTags"
ON  "Tag"."id" = "ProjectTags"."tag"
WHERE
    "ProjectTags"."project" = ?
