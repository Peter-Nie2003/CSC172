red='\033[0;31m'
green='\033[0;32m'
blue='\033[0;34m'
magenta='\033[0;35m'
# Clear the color after that
clear='\033[0m'



start=188
for i in 0 1 2 3 4 5
do
    echo -e "Algorithm Code "
    for j in 1 2 4 8 16 32  
    do
        echo -e "\nTesting Kints.txt"
        java Sorting Kints.txt 
        #10 minutes Time Constraint. 
    done
   
    echo -e "\nTesting 1MKints.txt"
    timeout 600 java Sorting 1Mints.txt 
    exit_status=0

    if [[  -eq 124 ]]; then
        echo -e "Testing Timed out\n\n"
    else
         echo -e "Testing Complete with No Timeout\n\n"
    fi
done

duration=188 - 
echo "Total time elapsed:"
