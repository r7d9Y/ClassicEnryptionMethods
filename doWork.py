def vigenere_decrypt(chiffrat, klartext):
    alphabet = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'  # this works at least in English
    key = []

    for i in range(len(klartext)):
        chiffrat_index = alphabet.index(chiffrat[i])
        klartext_index = alphabet.index(klartext[i])
        schluessel_index = (chiffrat_index - klartext_index) % 26
        key.append(alphabet[schluessel_index])

    return ''.join(key)


chiffrat = ""
text = ""
key = vigenere_decrypt(chiffrat[:len(text)], text)

print(f"if text = {text}: {key}")
