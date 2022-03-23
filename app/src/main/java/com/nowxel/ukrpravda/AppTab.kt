package com.nowxel.ukrpravda

import android.content.Context

enum class AppTab {
    MAIN,
    NEWS,
    ARTICLES,
    COLUMNS,
    INTERVIEW,
    REPORTS,
    BLOGS,
    PODCASTS,
    PROJECTS,
    ARCHIVES;

    fun toLocalizedString(context: Context): String = context.getString(
        when (this) {
            MAIN -> R.string.main
            NEWS -> R.string.news
            ARTICLES -> R.string.articles
            COLUMNS -> R.string.columns
            INTERVIEW -> R.string.interview
            REPORTS -> R.string.reports
            BLOGS -> R.string.blogs
            PODCASTS -> R.string.podcasts
            PROJECTS -> R.string.projects
            ARCHIVES -> R.string.archives
        }
    )

    fun toUrl(): String = when (this) {
        MAIN -> "https://www.pravda.com.ua/"
        NEWS -> "https://www.pravda.com.ua/news/"
        ARTICLES -> "https://www.pravda.com.ua/articles/"
        COLUMNS -> "https://www.pravda.com.ua/columns/"
        INTERVIEW -> "https://www.pravda.com.ua/interview/"
        REPORTS -> "https://www.pravda.com.ua/reports/"
        BLOGS -> "https://blogs.pravda.com.ua/"
        PODCASTS -> "https://www.pravda.com.ua/podcasts/"
        PROJECTS -> "https://www.pravda.com.ua/projects/"
        ARCHIVES -> "https://www.pravda.com.ua/archives/"
    }
}