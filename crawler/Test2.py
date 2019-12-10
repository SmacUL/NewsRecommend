



def xp_section(tag, type, name, index):

    final_str = str("%s" % tag)
    if type is not None and name is not None:
        final_str += str("[@%s='%s']" % (tag, name))
    if index is not None:
        final_str += str('[%d]' % index)
    return final_str


    # if index is not None:
    #     return str("%s[@%s='%s'][%d]" % (tag, type, name, index))
    # else:
    #     return str("%s[@%s='%s']" % (tag, type, name))

def xp_assemble(sections):
    if sections[0][0:2] == '//':
        return str('//'.join(sections))
    else:
        return str('//' + '//'.join(sections))

print(xp_assemble([xp_section('div', 'class', 'hh', None), xp_section('div', 'class', 'hh', 2)]))

print(xp_assemble([xp_assemble([xp_section('div', 'class', 'hh', None), xp_section('div', 'class', 'hh', 2)]), xp_section('div', 'class', 'hh', 2)]))

