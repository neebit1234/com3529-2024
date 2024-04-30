from subprocess import run, PIPE

def run_program(program, input_string):
    prog_args = []
    execution = run(['java', program] + prog_args, stdout=PIPE, stderr=PIPE, input=input_string.encode("utf-8"))
    return execution