## Week 3 Assignment: Enhancing COMS with Cybernetic Organ Simulation Using Recursion

---

## Objective
Develop a recursive simulation of a simplified cybernetic organ system consisting of a Heart, Lung, and Brain. The simulation should model the interactions between these organs over time, considering their health, specific attributes, and interdependencies.

## System Components

### 1. Heart
- Attribute: Pump Rate (40 to 100 beats per minute)
- Initial Pump Rate: 70
- Health: 0 to 100

### 2. Lung
- Attribute: Oxygen Level (70% to 100%)
- Initial Oxygen Level: 95%
- Health: 0 to 100

### 3. Brain
- Attribute: Control Efficiency (50 to 100)
- Initial Control Efficiency: 90
- Health: 0 to 100

## Simulation Rules

1. The simulation runs for a maximum of 100 time steps.
2. Each organ starts with 100 health points.
3. The simulation ends if any organ's health reaches 0 or after 100 time steps.
4. In each time step, update organs in the order: Heart, Lung, Brain.

## Update Formulas

### Heart Update
1. Pump Rate Update:
   ```
   newPumpRate = currentPumpRate + (brainControlEfficiency / 10) - 5 + randomFluctuation
   ```
   where randomFluctuation is between -4 and 3

2. Health Update:
   ```
   healthChange = -1 + (lungOxygenLevel / 25) - 2
   ```

### Lung Update
1. Oxygen Level Update:
   ```
   newOxygenLevel = currentOxygenLevel + (heartPumpRate / 20) - 3 + randomFluctuation
   ```
   where randomFluctuation is between -2 and 1

2. Health Update:
   ```
   healthChange = -1 + (heartPumpRate / 25) - 2
   ```

### Brain Update
1. Control Efficiency Update:
   ```
   newControlEfficiency = currentControlEfficiency + (lungOxygenLevel / 20) - 3 + randomFluctuation
   ```
   where randomFluctuation is between -2 and 1

2. Health Update:
   ```
   healthChange = -1 + (lungOxygenLevel / 25) - 2
   ```

## Random Events
- 10% chance per time step of a random health change event
- If triggered, randomly select one organ and change its health by -10 to +10 points

## Output Requirements

1. Initial State Print-out
    
    ```shell
        Time: 100
        Initial States:
        Heart Health: 100
        Lung Health: 100
        Brain Health: 100
    ```
2. Per-Step Output (for each time step)
    ```shell
        Time: 5
        Heart Health: 99 | Pump Rate: 72
        Lung Health: 98  | Oxygen Level: 94
        Brain Health: 99 | Control Efficiency: 89
    ```
   
3. Health Alert (when any organ's health drops below 25%)
    ```shell
        ALERT at Time 44: Brain Critical! Health at 35%
    ```
   
4. Random Event Notification
    ```shell
        EVENT at Time 20: Random health change for heart by 8%
    ```
5. Final Summary
    ```shell
        Simulation Ended:
        Time: 100
        Heart Health: 0
        Lung Health: 88
        Brain Health: 70
        Simulation Result: Failure
    ```
   
   OR

    ```shell
        Simulation Ended:
        Time: 100
        Heart Health: 100
        Lung Health: 100
        Brain Health: 100
        Simulation Result: Success
    ```

## Implementation Requirements

1. Use recursion for the main simulation loop
2. Implement separate classes for each organ
3. Use a random number generator for fluctuations and events
4. Ensure all attribute values stay within their defined ranges
5. Follow the specified output format

## Evaluation Criteria
- Correct implementation of recursion (20)
- Adherence to output requirements (10)
- Code organization and clarity (10)
