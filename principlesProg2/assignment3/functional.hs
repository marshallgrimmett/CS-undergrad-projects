list = [0,1,4,6,0,2,0,0,5,5,4,0,3]  -- list of integers

-- occurs function
-- input:
-- 	value - integer to be counted
-- 	lst - list of integers
-- output: integer denoting how many times value occured
occurs :: Integer -> [Integer] -> Integer
occurs value lst | null lst           = 0
                 | head lst == value  = 1 + occurs value (tail lst)
                 | otherwise          = occurs value (tail lst)

-- main: prints the value of occurs
main = putStrLn $ "Number of zeros: " ++ show(occurs 0 list)

