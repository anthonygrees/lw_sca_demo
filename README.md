# lw_sca_java.
  
This demo repo runs a Static Composition Analysis SCA via a GitHub Actions pipeline to identify Vulnerabilities in a Java Application.  
  
As well as SCA & SAST, Lacework can also scan Containers for security vulnerabilities in a GitHub Actions pipeline. An example this can be found here - https://github.com/anthonygrees/lw_container_scanner_demo    
  
### Manual Commands
To run manually, use the following commands.  
  
```bash
$ lacework sca dir . -o sca.json
  
OR
  
$ lacework sca dir .
```
  
### Creating secrets
Before attempting to run this action, you should add three secrets LW_ACCOUNT_NAME, LW_API_KEY and LW_API_SECRET to your GitHub repository (or, better yet, your GitHub organization so they can be shared accross all your repositories). The value for these secrets can be obtained by following the instructions here to create an API key and then download it.
  
### On push
To run an analysis on pushes that logs alerts, create a file called .github/workflows/code-analysis-push.yml with this content:
  
```yaml
on:
  push:
    branches: [main]

env:
  LW_ACCOUNT_NAME: ${{ secrets.LW_ACCOUNT_NAME }}
  LW_API_KEY: ${{ secrets.LW_API_KEY }}
  LW_API_SECRET: ${{ secrets.LW_API_SECRET }}

name: Lacework Code Security (Push)
jobs:
  run-analysis:
    runs-on: ubuntu-22.04
    name: Run analysis
    steps:
      - name: Checkout repository
        uses: actions/checkout@v3
      - name: Analyze
        uses: lacework/code-security-action@v1
        with:
          target: push
          tools: sca # Comma-separated list of tool(s) to use for scanning. Current options are sca and sast.
          # If using the SAST tool, uncomment the line below and point it to the generated classes directory
          # or built JAR for your project
          # classes: target
```
