private void calculateBMI() {
        String weightStr = etWeight.getText().toString().trim();
        String heightStr = etHeight.getText().toString().trim();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            Toast.makeText(this, "Please enter both weight and height", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double weight = Double.parseDouble(weightStr);
            double height = Double.parseDouble(heightStr);

            if (weight <= 0 || height <= 0) {
                Toast.makeText(this, "Weight and height must be positive numbers", Toast.LENGTH_SHORT).show();
                return;
            }

            // BMI = weight(kg) / height(m)²
            double bmi = weight / (height * height);
            String bmiFormatted = String.format("%.2f", bmi);

            String category;

            if (bmi < 18.5) {
                category = "Underweight";
            } else if (bmi < 25) {
                category = "Normal";
            } else if (bmi < 30) {
                category = "Overweight";
            } else {
                category = "Obese";
            }

            String resultText = "BMI: " + bmiFormatted + "\nCategory: " + category;
            tvResult.setText(resultText);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }

