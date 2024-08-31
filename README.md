# cybernetic-organs-system
A futuristic company specializing in creating bio-compatible cybernetic organs for human augmentation and replacement. This project will require a deep understanding of object-oriented programming, data structures, and algorithms to simulate the complex interactions between biological and mechanical components.




## Classes [UML diagram](www.plantuml.com/plantuml/png/hL71IiD04BtdAvOzfKgANaMa40yM50M_O9ATXe7Dh6GdXIB-kxlT9DXjmKjpICZCUu_ttcoym21ZRulMWlUgFZGuC0grxqC7hBuB5PwAZ7fGn9B-UcVGXi6d3CHTckr6ReKSWoKvPBlMzLyWrD3vxhP3UKO1ihvSPIlozKIqMCOlijGNfIApSSuYyABw5at-rVmffemVIMhEnj1ZPXWwFCcBXbgmB-J53NauOYzWBPfZOJviNmFkCIloAVa2as2bY--0pM3HxjwHML9CNhUySnUp75bRtYD7Qykvvi6LtIJqwVbNvxneRovPtsjLLKhVhTStEWS6gixwqqKMwN-16QgB3R8PU_iB):

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
