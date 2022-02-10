package ru.gb.cinemawithkotlin.view

import ru.gb.cinemawithkotlin.model.Cinema

interface OnItemViewClickListener {
    abstract fun onItemViewClick(cinema: Cinema)
}