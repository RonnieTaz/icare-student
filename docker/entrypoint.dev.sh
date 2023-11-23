#!/bin/sh

# Function to install Node dependencies
install_dependencies() {
  echo "Installing Node dependencies..."
  npm install --legacy-peer-deps
}

# Function to copy proxy-config.example.json if proxy-config.json doesn't exist
copy_proxy_config() {
  if [ ! -f "proxy-config.json" ]; then
    echo "Copying proxy-config.example.json to proxy-config.json..."
    cp proxy-config.example.json proxy-config.json
  fi
}

# Check if Node dependencies are installed
if [ ! -d "node_modules" ]; then
  install_dependencies
fi

# Check and copy proxy-config.json if it doesn't exist
copy_proxy_config

# Increasing Node memory heap size
export NODE_OPTIONS="--max-old-space-size=8192"

# Run the command received as arguments (CMD or command passed while running the container)
exec "$@"
