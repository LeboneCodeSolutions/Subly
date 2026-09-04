# Fix RegistrationViewModel Validation and Name Collision

The current code in `RegistrationViewModel.java` has a name collision where a member variable has the same name as the `RegistrationUiState` class. This shadows the class name, making it difficult to instantiate nested classes like `RegistrationUiState.Error`. Additionally, the validation check lacks null safety and the `new` keyword is missing for class instantiation.

## Proposed Changes

### [Registration Module]

#### [MODIFY] [RegistrationViewModel.java](file:///Users/lebonengobese/AndroidStudioProjects/Subly/app/src/main/java/com/example/subly/ui/registration/RegistrationViewModel.java)

- Rename the member variable `RegistrationUiState` to avoid shadowing the class name.
- Update `_uiState` initialization to use a sensible initial state (e.g., `RegistrationUiState.Idle.INSTANCE`).
- Fix the validation block:
    - Use `new` to instantiate `RegistrationUiState.Error`.
    - Add null checks and `trim()` for better validation.
    - Use `android.text.TextUtils.isEmpty` for concise null-safe checks.

## Verification Plan

### Automated Tests
- I will check if there are existing tests for `RegistrationViewModel` and update/add them if necessary.
- Run `./gradlew :app:assembleDebug` to ensure it compiles.

### Manual Verification
- Deploy the app and verify that the registration screen correctly shows an error when fields are empty.
