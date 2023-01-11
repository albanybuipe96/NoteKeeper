package com.nexus.notekeeper.di

import android.content.Context
import androidx.room.Room
import com.nexus.notekeeper.data.NoteDao
import com.nexus.notekeeper.data.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDao(db: NoteDatabase): NoteDao {
        return db.noteDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext ctx: Context): NoteDatabase {
        return Room.databaseBuilder(ctx, NoteDatabase::class.java, "note_db")
            .fallbackToDestructiveMigration().build()
    }

}