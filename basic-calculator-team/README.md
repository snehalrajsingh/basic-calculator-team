# Basic Calculator — Team Git Branching Exercise

A small command-line calculator written in Java. The team develops each arithmetic
operation on a separate branch and merges the completed branches into `main`.

## Team task allocation

| Team member | Branch | File to implement |
|---|---|---|
| Member 1 | `feature/addition` | `src/calculator/Addition.java` |
| Member 2 | `feature/subtraction` | `src/calculator/Subtraction.java` |
| Member 3 | `feature/multiplication` | `src/calculator/Multiplication.java` |
| Member 4 | `feature/division` | `src/calculator/Division.java` |

The integration/lead member maintains `Main.java`, reviews pull requests, and merges
the feature branches. If the team has fewer than four members, one member can take
more than one operation.

## 1. Set up the shared repository

One team member creates an empty GitHub repository, then runs:

```bash
git init
git add .
git commit -m "Add calculator project structure"
git branch -M main
git remote add origin <YOUR_GITHUB_REPOSITORY_URL>
git push -u origin main
```

Other members clone it:

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
cd basic-calculator-team
```

## 2. Each member works on their own branch

Example for Member 1 (the other members use their assigned branch name):

```bash
git switch main
git pull origin main
git switch -c feature/addition
```

Implement only the assigned operation file, then commit and push:

```bash
git add src/calculator/Addition.java
git commit -m "Implement addition operation"
git push -u origin feature/addition
```

Repeat with the relevant filename and branch for each member.

## 3. Merge into main

Each member opens a Pull Request on GitHub:
- Base branch: `main`
- Compare branch: their `feature/...` branch
- Ask another member to review it.
- Merge the Pull Request after the review and checks pass.

Alternatively, the integration lead can merge locally:

```bash
git switch main
git pull origin main
git merge --no-ff origin/feature/addition
git merge --no-ff origin/feature/subtraction
git merge --no-ff origin/feature/multiplication
git merge --no-ff origin/feature/division
git push origin main
```

If merging locally, fetch the branches first with `git fetch origin`.

## 4. Compile and run

Requires a JDK (Java 8 or newer).

From the project root:

```bash
javac -d out src/calculator/*.java
java -cp out calculator.Main
```

Example:

```text
=== Basic Calculator ===
Enter first number: 12
Enter operator (+, -, *, /): *
Enter second number: 3
Result: 36.0
```

## 5. Test checklist

- [ ] Addition: `8 + 2` gives `10`
- [ ] Subtraction: `8 - 2` gives `6`
- [ ] Multiplication: `8 * 2` gives `16`
- [ ] Division: `8 / 2` gives `4`
- [ ] Division by zero displays a clear error
- [ ] Unsupported operators display an error
- [ ] All four feature branches are merged into `main`
- [ ] The final `main` branch compiles and runs

## Git collaboration rules

1. Never commit directly to `main` during feature development.
2. Keep each member's changes limited to their assigned file.
3. Pull the latest `main` before creating a branch.
4. Use clear commit messages and review Pull Requests.
5. Resolve conflicts with the team; do not blindly overwrite another member's work.
