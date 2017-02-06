# Name
  Name Size:
      Empty.                   [single][property emptyname]
      Not empty.
  Name Characters:
      Has Special Characters.  [error][if !emptyname] [property SpecialChar]
      No Special Characters.   [if !emptyname]
  Name Repeated:
      Same Supplier.           [error][if !emptyname && !SpecialChar]
      Different Supplier.      [if !emptyname && !SpecialChar]


# Barcode
  Barcode Size:
      Empty.                                [single][property emptyBarcode]
      Not Empty.
  Barcode Contains:
      Same barcode as another item.         [error][if !emptyBarcode]
      Non Numeric Barcode.                  [error][if !emptyBarcode]    
      Numeric Barcode between 99 and 9999.  [if !emptyBarcode]
	  100.                                  [single][if !emptyBarcode]
      9998.                                 [single][if !emptyBarcode]
	  Over 9998.                            [error][if !emptyBarcode]
	  Less than 100.                        [error][if !emptyBarcode]


# Quantity
  Quantity Size:
      Empty.                      [single][property emptyQuantity]
	  Not Empty.
  Quantity Contains:
      Non Numeric.                [error][if !emptyQuantity]                
	  Numeric Between 0 and 100.  [if !emptyQuantity]
	  Numeric Less than 0.        [error][if !emptyQuantity]
	  Numeric Over 100.           [error][if !emptyQuantity]
	  Numeric - 0.                [single][if !emptyQuantity]
	  Numeric - 100.              [single][if !emptyQuantity]


# Supplier
  Supplier Size:
      Empty.                  [single][property emptySupplier]
	  Not Empty.
  Supplier Contains:
      Special Characters.     [error][if !emptySupplier]
	  No Special Characters.  [if !emptySupplier]


# Item Type
  Item Type Size:
      Empty.             [single][property emptyType]
	  Not Empty.
  Item Type Contains:
      Allowed Type.      [if !emptyType]
	  Not Allowed Type.  [error]