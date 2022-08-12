package com.example.articleblog.ui.model

data class ArticlesUiModel(
    val articlesList: List<ArticleUiModel>,
)

data class ArticleUiModel(
    val id: Int,
    val title: String,
    val text: String,
    val categories: List<CategoryUiModel>,
    val articleInfo: ArticleInfoUiModel,
)

data class CategoryUiModel(
    val id: Int,
    val category: String,
)

data class ArticleInfoUiModel(
    val id: Int,
    val likes: String,
    val views: String,
)

object Articles {
    val articleList = listOf(
        ArticleUiModel(
            id = 1,
            title = "Ричард великий",
            text = "Его брат Ричард, в начале XVI века бежали ко двору императора СвященнойРимской империи, став пешками в международной политике. Существовали также другие родас таким прозванием, но неизвестно, находятся ли они в родстве",
            categories = listOf(
                CategoryUiModel(id = 1, category = "History"),
                CategoryUiModel(id = 2, category = "Biography"),
                CategoryUiModel(id = 3, category = "Documentary"),
            ),
            articleInfo = ArticleInfoUiModel(id = 1, likes = "24", views = "438")
        ),
        ArticleUiModel(
            id = 1,
            title = "Ричард великий",
            text = "Его брат Ричард, в начале XVI века бежали ко двору императора СвященнойРимской империи, став пешками в международной политике. Существовали также другие родас таким прозванием, но неизвестно, находятся ли они в родстве",
            categories = listOf(
                CategoryUiModel(id = 1, category = "History"),
                CategoryUiModel(id = 2, category = "Biography"),
                CategoryUiModel(id = 3, category = "Documentary"),
            ),
            articleInfo = ArticleInfoUiModel(id = 1, likes = "24", views = "438")
        ),
        ArticleUiModel(
            id = 1,
            title = "Ричард великий",
            text = "Его брат Ричард, в начале XVI века бежали ко двору императора СвященнойРимской империи, став пешками в международной политике. Существовали также другие родас таким прозванием, но неизвестно, находятся ли они в родстве",
            categories = listOf(
                CategoryUiModel(id = 1, category = "History"),
                CategoryUiModel(id = 2, category = "Biography"),
                CategoryUiModel(id = 3, category = "Documentary"),
            ),
            articleInfo = ArticleInfoUiModel(id = 1, likes = "24", views = "438")
        ),
        ArticleUiModel(
            id = 1,
            title = "Ричард великий",
            text = "Его брат Ричард, в начале XVI века бежали ко двору императора СвященнойРимской империи, став пешками в международной политике. Существовали также другие родас таким прозванием, но неизвестно, находятся ли они в родстве",
            categories = listOf(
                CategoryUiModel(id = 1, category = "History"),
                CategoryUiModel(id = 2, category = "Biography"),
                CategoryUiModel(id = 3, category = "Documentary"),
            ),
            articleInfo = ArticleInfoUiModel(id = 1, likes = "24", views = "438")
        ),
        ArticleUiModel(
            id = 1,
            title = "Ричард великий",
            text = "Его брат Ричард, в начале XVI века бежали ко двору императора СвященнойРимской империи, став пешками в международной политике. Существовали также другие родас таким прозванием, но неизвестно, находятся ли они в родстве",
            categories = listOf(
                CategoryUiModel(id = 1, category = "History"),
                CategoryUiModel(id = 2, category = "Biography"),
                CategoryUiModel(id = 3, category = "Documentary"),
            ),
            articleInfo = ArticleInfoUiModel(id = 1, likes = "24", views = "438")
        ),
        ArticleUiModel(
            id = 1,
            title = "Ричард великий",
            text = "Его брат Ричард, в начале XVI века бежали ко двору императора СвященнойРимской империи, став пешками в международной политике. Существовали также другие родас таким прозванием, но неизвестно, находятся ли они в родстве",
            categories = listOf(
                CategoryUiModel(id = 1, category = "History"),
                CategoryUiModel(id = 2, category = "Biography"),
                CategoryUiModel(id = 3, category = "Documentary"),
            ),
            articleInfo = ArticleInfoUiModel(id = 1, likes = "24", views = "438")
        ),
    )
}