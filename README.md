# SCODi DeepL Integration

This project implements DeepL translation service integration for SCODi 4P.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- Eclipse IDE
- DeepL API key

### Import into Eclipse

1. Clone the repository:
   ```bash
   git clone https://github.com/thenzler/scodi-deepl-integration.git
   ```

2. Import as Maven project:
   - Open Eclipse
   - File -> Import -> Maven -> Existing Maven Projects
   - Select the cloned repository directory
   - Click Finish

### Configuration

1. Open `src/main/resources/application.properties`
2. Set your DeepL API key:
   ```properties
   scodi.translation.deepl.api-key=your-api-key-here
   ```

### Running the Application

1. Right-click on `TranslationApplication.java`
2. Run As -> Java Application

### Running Tests

1. Right-click on the project
2. Run As -> JUnit Test

## Project Structure

- `src/main/java/com/scodi/translation/`
  - `TranslationApplication.java` - Main application class
  - `service/` - Translation service implementation
  - `config/` - Configuration classes
  - `exception/` - Custom exceptions

## Development

### Adding New Features

1. Create feature branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```

2. Implement changes
3. Run tests
4. Create pull request

## License

This project is proprietary software of SCODi.