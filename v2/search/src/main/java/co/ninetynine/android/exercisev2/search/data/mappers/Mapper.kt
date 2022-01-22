package co.ninetynine.android.exercisev2.search.data.mappers

interface Mapper<E, V> {

  fun mapToRoom(input: E): V

  fun mapToModel(input: V): E

  fun mapAllToRoom(input: List<E>):List<V>

  fun mapAllToModel(input: List<V>):List<E>
}