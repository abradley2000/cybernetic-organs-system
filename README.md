# cybernetic-organs-system
A futuristic company specializing in creating bio-compatible cybernetic organs for human augmentation and replacement. This project will require a deep understanding of object-oriented programming, data structures, and algorithms to simulate the complex interactions between biological and mechanical components.




## Classes

### CyberneticOrgan
- Attributes: `id`, `model`, `functionality`, `compatibility`
- Methods:
    - `getDetails()`: Returns a string containing the organ’s details.
    - `isCompatible(String patientCompatibility)`: Checks organ compatibility with a patient.
    - `getModel()`: Returns the model of the organ.

### Patient
- Attributes: `name`, `age`, `medicalHistory`, `installedOrgans`
- Methods:
    - `addOrgan(CyberneticOrgan organ)`: Adds an organ to the patient’s list of installed organs.
    - `getPatientInfo()`: Returns a string with the patient’s details and installed organs.

### OrganInventory
- Attributes: `inventory`
- Methods:
    - `addOrgan(CyberneticOrgan organ)`: Adds a new organ to the inventory.
    - `getOrgan(String model)`: Retrieves an organ by its model from the inventory.
