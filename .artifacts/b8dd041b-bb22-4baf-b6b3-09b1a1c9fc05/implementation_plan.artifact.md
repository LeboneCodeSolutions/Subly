# Implementation Plan - Fix RegistrationViewModel instantiation error

The application is crashing because `RegistrationViewModel` has a constructor parameter (`UserRegistrationInteractor`), but it is being instantiated in `RegistrationActivity` using the `by viewModels()` delegate without a `ViewModelProvider.Factory`. Android's default ViewModel provider can only instantiate ViewModels with a no-argument constructor.

To fix this, I will implement a `ViewModelProvider.Factory` and wire up the required dependencies.

## Proposed Changes

### [ui/registration]

#### [NEW] [RegistrationViewModelFactory.kt](file:///Users/lebonengobese/AndroidStudioProjects/Subly/app/src/main/java/com/example/subly/ui/registration/RegistrationViewModelFactory.kt)
Create a factory class that knows how to create an instance of `RegistrationViewModel` with its required `UserRegistrationInteractor`.

#### [MODIFY] [RegistrationActivity.kt](file:///Users/lebonengobese/AndroidStudioProjects/Subly/app/src/main/java/com/example/subly/ui/registration/RegistrationActivity.kt)
Update the `viewModel` instantiation to use the new factory. For now, dependencies will be initialized within the activity to resolve the crash, though a dependency injection framework like Hilt would be a better long-term solution.

### [data/local]

#### [MODIFY] [UserRoom.kt](file:///Users/lebonengobese/AndroidStudioProjects/Subly/app/src/main/java/com/example/subly/data/local/UserRoom.kt)
Fix suspicious `androidx.room3` imports to standard `androidx.room` to ensure Room database can be correctly instantiated.

#### [MODIFY] [UserEntity.kt](file:///Users/lebonengobese/AndroidStudioProjects/Subly/app/src/main/java/com/example/subly/data/local/UserEntity.kt)
Fix suspicious `androidx.room3` imports to standard `androidx.room`.

## Verification Plan

### Automated Tests
- I will attempt to build the project to ensure no syntax errors were introduced.
- `gradlew assembleDebug`

### Manual Verification
- Run the app and navigate to the Registration screen to verify it no longer crashes on start.
