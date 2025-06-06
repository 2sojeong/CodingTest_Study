SELECT a.ITEM_ID, b.ITEM_NAME, b.RARITY FROM
(SELECT b.ITEM_ID, a.ITEM_NAME, a.RARITY FROM ITEM_INFO a RIGHT JOIN ITEM_TREE b on a.ITEM_ID = b.PARENT_ITEM_ID 
WHERE a.RARITY = "RARE") a LEFT JOIN ITEM_INFO b on a.ITEM_ID = b.ITEM_ID ORDER BY a.ITEM_ID DESC