package com.frenzelts.team99.common.visitable

class LoadingUiModel(override val id: Long = ID) : Visitable<BaseTypeFactory> {
    override fun type(typeFactory: BaseTypeFactory): Int {
        return typeFactory.type(this)
    }

    companion object {
        const val ID = 101L
    }

    override fun areContentsTheSame(newItem: BaseVisitable): Boolean {
        return false
    }
}