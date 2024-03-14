package com.frenzelts.team99.common.visitable

class ErrorUiModel(override val id: Long = ID) : Visitable<BaseTypeFactory> {
    override fun type(typeFactory: BaseTypeFactory): Int {
        return typeFactory.type(this)
    }

    companion object {
        const val ID = 102L
    }

    override fun areContentsTheSame(newItem: BaseVisitable): Boolean {
        return false
    }
}