package org.example.electroniccomponentretailserver

import kotlin.reflect.KMutableProperty
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.memberProperties

fun <T : Any> updateEntity(existingEntity: T, updatedEntity: T): T {
    val kClass = updatedEntity::class

    for (property in kClass.memberProperties) {
        if (property is KMutableProperty1<*, *>) {
            val mutableProperty = property as? KMutableProperty1<T, Any?>
            mutableProperty?.let {
                val updatedValue = mutableProperty.get(updatedEntity)
                if (updatedValue != null) {
                    mutableProperty.setter.call(existingEntity, updatedValue)
                }
            } ?: run {
                // Handle the case where the cast fails
            }
        }
    }
    return existingEntity
}
