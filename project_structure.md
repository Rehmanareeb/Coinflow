java/
└── com/
    └── coinflow/
        ├── CoinflowApplication.java        # Main application entry point
        │
        ├── controller/                    # THE DOOR
        │   └── WalletController.java
        │
        ├── service/                       # THE BRAIN
        │   └── WalletService.java
        │
        ├── repository/                    # THE STORAGE
        │   └── WalletRepository.java
        │   └──TransactionRepository.java
        ├── entity/                        # THE DATA MODELS
        │   └── Wallet.java
            └── Transaction.java                # Maps to DB table
        │
        └── dto/                           # THE DATA PACKETS
            └── TransferRequest.java       # JSON format
