# NoteTaking API

Simple REST API built with Kotlin and Spring Boot to manage notes in memory.

## What this project does

This project exposes HTTP endpoints to:
- List all notes
- Create a new note
- Delete a note by ID

Notes are stored in an in-memory `mutableList`, so data is reset every time the application restarts.

## Tech stack

- Kotlin `1.9.25`
- Spring Boot `3.4.4`
- Gradle (Kotlin DSL)
- Java `21`

## Project structure

- `src/main/kotlin/dev/abreu/notetaking/controllers/NoteController.kt`: REST endpoints and exception handlers.
- `src/main/kotlin/dev/abreu/notetaking/services/NoteService.kt`: Service layer between controller and repository.
- `src/main/kotlin/dev/abreu/notetaking/dataSources/NoteRepository.kt`: In-memory storage and CRUD operations.
- `src/main/kotlin/dev/abreu/notetaking/model/Note.kt`: Note data model (`id`, `title`, `description`).

## API endpoints

Base path: `/notes`

### `GET /notes`
Returns all notes.

Example response:

```json
[
  {
    "id": "e0f9c790-8c89-4f61-9fe6-8d4f7e8f7f9a",
    "title": "First Note",
    "description": "This is the content of the first note."
  }
]
```

### `POST /notes`
Creates a note.

Request body:

```json
{
  "title": "Study Kotlin",
  "description": "Review data classes and collections"
}
```

You can also provide an `id`. If an existing `id` is sent, API returns `400 Bad Request`.

### `DELETE /notes/{id}`
Deletes a note by ID.

If ID is not found, API returns `404 Not Found`.

## Error handling

The controller maps exceptions to HTTP status codes:
- `NoSuchElementException` -> `404 Not Found`
- `IllegalArgumentException` -> `400 Bad Request`

## Running locally

Requirements:
- Java 21 available in your environment

Run the app:

```bash
./gradlew bootRun
```

Run tests:

```bash
./gradlew test
```

The API runs on port `8080` by default (unless overridden in your environment/config).

## Current limitations

- No database persistence (all notes are in memory)
- No authentication/authorization
- Basic validation only

## Next improvements (optional)

- Persist notes in a relational database
- Add DTOs and request validation annotations
- Add integration tests for each endpoint
- Add OpenAPI/Swagger documentation

