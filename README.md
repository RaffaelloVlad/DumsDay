# DumsDay — Doomsday Algorithm Implementation

A lightweight, console-based Java application that implements John Conway's **Doomsday algorithm** to instantly calculate the day of the week for any given calendar date.

---

## 🛠️ Tech Stack
- **Language:** Java (JDK 17 or higher recommended)
- **Build Automation:** Maven
- **Concepts:** Mathematical Algorithms, Calendar Logic, Input Validation

---

## 🚀 Key Features
- **Pure Conway Implementation:** Faithfully executes all stages of Conway's Doomsday rule, including Century Index calculation, intra-century year offset calculations, and month-specific anchor mapping.
- **Bulletproof Validation:** Features an advanced input parsing system that is inherently exception-free. It accurately verifies calendar boundaries, varying month lengths, and leap years.
- **Lightweight & Efficient:** The entire algorithm is optimized and contained within a single, highly structured, and readable Java component. It computes results in constant time \(O(1)\) entirely through basic arithmetic and modulo operations, bypassing heavy system-level packages like `java.time`.
- **Transparent Breakdown:** Provides an informative console log that strips down the date and reveals intermediate values (e.g., Year Doomsday, Month Anchor) to show exactly how the math reached the final day.

---

## 🧠 Behind the Algorithm (Quick Overview)

Conway's algorithm relies on the fact that a set of memorable dates always falls on the exact same day of the week within any given year. This repeating day is called the **Doomsday** of that year.

Examples of these "anchor days" include:
* **4/4, 6/6, 8/8, 10/10, 12/12**
* **9/5, 5/9, 11/7, 7/11** (remembered by the phrase *"working 9-to-5 at the 7-Eleven"*)
* The **last day of February** (28th in common years, 29th in leap years)

Once the application computes the specific Doomsday for the requested year, it simply evaluates the distance between your input date and the nearest anchor to determine the exact day of the week.

---

## 💻 How to Run in Your Console

Follow these steps to build and execute the project directly from your terminal.

### Prerequisites
* **JDK 17** or newer installed.
* **Apache Maven** installed.

### Step-by-Step Instructions

1. **Navigate to the project root directory:**
   ```bash
   cd /path/to/your/project/dumsday
   ```

2. **Clean and build the executable JAR file:**
   ```bash
   mvn clean package
   ```
   *Once the build completes successfully, an executable `.jar` file will be generated inside the newly created `target/` directory.*

3. **Run the compiled application:**
   ```bash
   java -jar target/dumsday-1.0-SNAPSHOT.jar
   ```

4. **Usage:**
   When prompted, enter a date in the `dd.mm.yyyy` format (e.g., `04.10.2026`) and press **Enter**. The console will immediately return the calculated day of the week alongside the underlying algorithmic breakdowns. To exit the loop at any time, press `Ctrl + C`.