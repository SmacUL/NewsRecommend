export function translator(list) {
    let en = ['news_society', 'news_entertainment', 'news_tech', 'news_military', 'news_sports',
        'news_car', 'news_finance', 'news_world', 'news_fashion', 'news_travel',
        'news_discovery', 'news_baby', 'news_regimen', 'news_story', 'news_essay',
        'news_game', 'news_history', 'news_food'];
    let zn = ['社会', '娱乐', '科技', '军事', '体育', '汽车', '财经', '国际', '时尚', '旅游', '探索',
        '育儿', '养生', '故事', '美文', '游戏', '历史', '美食'];
    return list.map(function (item) {
        return zn[en.indexOf(item)];
    })
}

